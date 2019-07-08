/****************************************************************************************
 南京小视科技有限公司
 ****************************************************************************************/
package com.minivision.reus.common.service.other;

import com.minivision.reus.common.dto.resp.GetDirectoryDTO;
import com.minivision.reus.common.dto.resp.NodeTreeRespDTO;

import java.util.List;

/**
 * <Description>: DirectoryService<br>
 *
 * @author wcx<br>
 * @version 1.0<br>
 * @CreateDate 2019/07/08
 */
public interface DirectoryService {

    List<NodeTreeRespDTO> getDirectory(GetDirectoryDTO directoryDTO);
}
