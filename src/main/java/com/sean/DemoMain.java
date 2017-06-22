package com.sean;

import com.google.common.collect.Lists;
import com.qunar.mobile.logger.realtime.kafka.client.ConsumerConfigure;
import com.qunar.mobile.logger.realtime.kafka.client.IConsumerApply;
import com.qunar.mobile.logger.realtime.kafka.client.KafkaConsumerClient;
import com.sean.dao.TransactionService;
import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by guozhenbin on 2017/5/26.
 */
public class DemoMain {

    private static ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml","applicationContext-dao.xml");
//    private static ApplicationContext ctx2 = new ClassPathXmlApplicationContext("applicationContext-dao.xml");

    public static void main(String[] args) throws IOException {
//        kafkaConsumer();
        System.out.println(ctx.getBean("seanDriver"));
//        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        TransactionService service = ctx.getBean(TransactionService.class);

        try {
            service.saveEmployee(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Map<String,Object>> list = service.queryEmployee();
        System.out.println(list);

    }

    public static void kafkaConsumer() throws IOException {
        final String BROKER_0900 = "192.168.235.152:9092";
        ConsumerConfigure configure = ConsumerConfigure.newBuilder()
                .bootstrapServers(BROKER_0900)
                .keyDeserializer(StringDeserializer.class.getName())
                .valueDeserializer(StringDeserializer.class.getName())
                .autoOffsetReset("latest")
                .enableAutoCommit(true)
                .sessionTimeoutMs(30000)
                .autoCommitIntervalMs(3000)
                .heartbeatIntervalMs(2000)
                .maxPartitionFetchBytes(1000)
                .groupId("m_messagepushedit").build();
//        System.out.println(configure.toConfigMap());

        final KafkaConsumerClient consumerClient = new KafkaConsumerClient(configure);

        consumerClient.subscribe(Lists.newArrayList("test"), new ConsumerRebalanceListener() {
            public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
                consumerClient.getConsumer().commitAsync();
            }

            public void onPartitionsAssigned(Collection<TopicPartition> partitions) {

            }
        });

        Thread thread = new Thread(new Runnable() {
            public void run() {
                while(true){

                    try {
                        consumerClient.poll(5000, new IConsumerApply() {
                            public void apply(ConsumerRecord record) {
                                System.out.println(String.format("key:%s,value:%s", record.key(), record.value()));
                            }
                        }, KafkaConsumerClient.CommitType.AUTO, new KafkaConsumerClient.IdempotenceFilter() {

                            public boolean filted(ConsumerRecord record) {
                                return false;
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();

        if(System.in.read() != 0){
            System.exit(1);
        }
    }

}

