package com.orange.ilbun.service;

import com.orange.ilbun.model.Item;
import com.orange.ilbun.repository.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class ItemService {

    @Autowired
    ItemMapper itemMapper;

    public List<Item> printItemList() {
        return itemMapper.selectAll();
    }

    public Item itemdetail(Long itemId) {
        return itemMapper.selectByItemId(itemId);
    }
    public void insertItem(Item item, MultipartFile imgFile) throws IllegalStateException, IOException {

        String oriImgName = imgFile.getOriginalFilename();
        String imgName ="";

        String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/itemImg/";



        UUID uuid = UUID.randomUUID();

        String saveFileName = uuid + "_" + oriImgName;
        imgName = saveFileName;

        File saveFile = new File(projectPath, imgName);
        imgFile.transferTo(saveFile);

        item.setImage(imgName);
        item.setImagePath("/itemImg/"+imgName);
        itemMapper.insertItem(item);
    }
}
