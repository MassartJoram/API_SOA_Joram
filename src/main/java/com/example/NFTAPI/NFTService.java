package com.example.NFTAPI;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NFTService {

    @Autowired
    private NFTRepository NftRepository;

    public NFT add(NFT nft) throws ServiceException{
        if(this.NftRepository.findNftByName(nft.getName()) != null){
            throw new ServiceException("NFT bestaat al");
        }
        return this.NftRepository.save(nft);
    }

    public NFT update(NFT nft){
        if(nft.getId() < 1){
            throw new ServiceException("Id must be positive");
        }
        if(!this.NftRepository.existsById(nft.getId())){
            throw new ServiceException("NFT with this id does not exists");
        }
        NFT nftById = this.NftRepository.findNftByName(nft.getName());

        if(nftById != null && nftById.getId() != nft.getId()){
            throw new ServiceException("Nft with this name alreadt exists");
        }
        return this.NftRepository.save(nft);
    }

    public void delete(NFT nft){
        if(nft == null){
            throw new ServiceException("Cannot delete this nft");
        }
        this.NftRepository.delete(nft);
    }

    public void delete(long id)throws ServiceException{
        NFT nft = findNtfById(id).orElseThrow(() -> new ServiceException("Nft not found"));
        delete(nft);
    }

    public List<NFT> getAll(){
        return this.NftRepository.findAll();
    }

    public Optional<NFT> findNtfById(long id) {
        return NftRepository.findById(id);
    }

}
