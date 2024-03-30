package com.example.rental.framework.jpaadapter;

import com.example.rental.domain.RentalCard;
import com.example.rental.domain.vo.RentalCardNo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RentalCardRepository extends JpaRepository<RentalCard, RentalCardNo> {

    @Query("select m from RentalCard m where m.member.id = :id")
    Optional<RentalCard> findByMemberId(@Param("id") String memberId);

    @Query("select m from RentalCard m where m.rentalCardNo.no = :id")
    Optional<RentalCard> findById(@Param("id") Long rentalCardId);

}