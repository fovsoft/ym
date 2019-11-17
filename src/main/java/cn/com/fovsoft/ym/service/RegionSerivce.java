package cn.com.fovsoft.ym.service;

import cn.com.fovsoft.ym.dao.YmRegionDao;
import cn.com.fovsoft.ym.entity.YmRegion;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RegionSerivce {


    @Resource
    private YmRegionDao ymRegionDao;

    public List<YmRegion> getList(Integer id) {
        return ymRegionDao.getRegionList(id);
    }
}
