package com.example.UdemyCourse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "notice_details")
public class Notice {

    @Id
    @Column(name = "notice_id")
    private long noticeId;

    @Column(name = "notice_summary")
    private String noticeSummary;

    @Column(name = "notice_details")
    private String noticeDetails;

    @Column(name = "notice_begin_date")
    private LocalDate noticeBeginDate;

    @Column(name = "notice_end_date")
    private LocalDate noticeEndDate;

    @JsonIgnore
    @Column(name = "create_date")
    private LocalDate createDate;

    @JsonIgnore
    @Column(name = "update_date")
    private LocalDate updateDate;
}