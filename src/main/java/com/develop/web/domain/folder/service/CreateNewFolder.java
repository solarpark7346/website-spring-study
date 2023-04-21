package com.develop.web.domain.folder.service;

import com.develop.web.domain.folder.mapper.FolderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateNewFolder {
    private final FolderMapper folderMapper;

    public void addFolder(String name) {
        folderMapper.insertNewFolder(name);
    }
}
