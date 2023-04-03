package com.dokidoki.notice.api.response;

import com.dokidoki.notice.kafka.dto.KafkaAuctionEndDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class NoticeFailResp implements NoticeResp {
    private NoticeType type;
    private Long productId;
    private String productName;
    private Long auctionId;
    private Long finalPrice;
    private Long myFinalPrice;
    private boolean read;


    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime timeStamp;

    public static NoticeFailResp of(KafkaAuctionEndDTO dto, Long myFinalPrice) {
        NoticeFailResp resp = NoticeFailResp.builder()
                .type(NoticeType.PURCHASE_FAIL)
                .productId(dto.getProductId())
                .productName(dto.getProductName())
                .auctionId(dto.getAuctionId())
                .finalPrice(dto.getFinalPrice())
                .myFinalPrice(myFinalPrice)
                .timeStamp(dto.getEndTime())
                .build();
        return resp;
    }

    @Override
    public NoticeType typeIs() {
        return type;
    }

    @Override
    public void setRead(boolean bool) {
        this.read = bool;
    }

}
