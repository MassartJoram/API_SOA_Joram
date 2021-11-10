package com.example.NFTAPI;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.concurrent.atomic.AtomicLong;



@RestController
@RequestMapping("/api/nft")
public class NFTController {

    @Autowired
    private NFTService nftService;

    @GetMapping("/all")
    public  Iterable<NFT> getAllNfts(){ return this.nftService.getAll(); }

    @PostMapping("/add")
    public NFT addNft(@Valid @RequestBody NFT nft){
       try{
           return this.nftService.add(nft);
       } catch (Exception exc){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "addNFT" , exc);
       }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteNft(@PathVariable("id") long id){
        try{
            nftService.delete(id);
        }catch (ServiceException exc){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "name" , exc);
        }
    }

    @PutMapping("/update/{id}")
    public void updateNft(@PathVariable("id") long id , @Valid @RequestBody NFT nft){
        try {
            nft.setId(id);
            nftService.update(nft);
        }catch (ServiceException exc){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "name" , exc);
        }
    }



}
