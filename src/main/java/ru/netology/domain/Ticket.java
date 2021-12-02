package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private int time;
    private String departureAirport;
    private String arrivalAirport;

    @Override
    public int compareTo(Ticket p) {
        return this.price - p.price;
    }
}
