/****************************************************************************************
 南京小视科技有限公司
 ****************************************************************************************/
package com.minivision.reus.common.service.other.impl;

import com.google.common.collect.Lists;
import com.minivision.common.framework.tool.unique.UUIDGenerator;
import com.minivision.reus.common.dto.resp.GetDirectoryDTO;
import com.minivision.reus.common.dto.resp.NodeTreeRespDTO;
import com.minivision.reus.common.service.other.DirectoryService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * <Description>: DirectoryServiceImpl<br>
 *
 * @author wcx<br>
 * @version 1.0<br>
 * @CreateDate 2019/07/08
 */
@Service
public class DirectoryServiceImpl implements DirectoryService {

    /**
     * ROOT_DIRECTORY_ID根目录id
     */
    private static final String ROOT_DIRECTORY_ID = "1";

    @Override
    public List<NodeTreeRespDTO> getDirectory(GetDirectoryDTO directoryDTO) {
        List<NodeTreeRespDTO> list = Lists.newArrayList();
        NodeTreeRespDTO treeRespDTO = null;
        if (directoryDTO.getId().equals(ROOT_DIRECTORY_ID)) {
            //根目录就查询基础盘符
            File[] roots = File.listRoots();
            for (File file : roots) {
                treeRespDTO = new NodeTreeRespDTO();
                treeRespDTO.setId(UUIDGenerator.getUUID());
                treeRespDTO.setLabel(file.getPath());
                treeRespDTO.setValue(file.getPath());
                list.add(treeRespDTO);
            }

        } else {
            File directory = new File(directoryDTO.getDirectory());
            File[] listFiles = directory.listFiles();
            for (File file : listFiles) {
                if (file.isDirectory() && !file.getName().contains("$")) {
                    treeRespDTO = new NodeTreeRespDTO();
                    treeRespDTO.setId(UUIDGenerator.getUUID());
                    treeRespDTO.setValue(file.getPath());
                    treeRespDTO.setLabel(file.getName());
                    list.add(treeRespDTO);
                }
            }
        }
        return list;
    }
}
