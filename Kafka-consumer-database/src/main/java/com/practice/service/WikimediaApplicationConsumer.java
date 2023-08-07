package com.practice.service;

import com.practice.entity.WikimediaData;
import com.practice.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaListener;


@Service
public class WikimediaApplicationConsumer {

    private static final Logger logger = LoggerFactory.getLogger(WikimediaApplicationConsumer.class);

    private WikimediaDataRepository wikimediaDataRepository;

    public WikimediaApplicationConsumer(WikimediaDataRepository wikimediaDataRepository) {
        this.wikimediaDataRepository = wikimediaDataRepository;
    }


    @KafkaListener(
            topics="wikimedia_recentChange",
            groupId = "myGroup"
    )
    public void consume(String eventMessage){
        logger.info(String.format("Event message Received ->%s",eventMessage));
        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);

        wikimediaDataRepository.save(wikimediaData);

    }
}
