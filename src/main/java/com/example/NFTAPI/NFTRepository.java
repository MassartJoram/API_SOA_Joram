package com.example.NFTAPI;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@Repository
public interface NFTRepository extends JpaRepository<NFT , Long> {
    List<NFT> findAll();

    //NFT findNftById(long id);

    NFT findNftByName(String name);
}
