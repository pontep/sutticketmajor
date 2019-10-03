// package com.cpe.black.entity;

// import java.util.Collection;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.FetchType;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.OneToMany;
// import javax.persistence.SequenceGenerator;
// import javax.persistence.Table;

// import lombok.Data;
// import lombok.NoArgsConstructor;
// import lombok.NonNull;

// @Data
// @Entity
// @NoArgsConstructor
// @Table(name="SEAT")
// public class Seat {
//     @Id
//     @SequenceGenerator(name="seat_seq",sequenceName="seat_seq")               
//     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seat_seq")  
//     @Column(name = "SEAT_ID", unique = true, nullable = true)
//     private @NonNull Long id;

//     private @NonNull int seat;

//     @OneToMany(fetch = FetchType.EAGER)
//     private Collection<ShowSchedule> schedule;
// }