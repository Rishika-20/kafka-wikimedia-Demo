package com.practice.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="wikimedia_demo")
@Getter
@Setter

public class WikimediaData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String wikiEventData;

    public void setWikiEventData(String eventMessage) {
          this.wikiEventData = eventMessage;
    }
}