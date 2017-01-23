package com.data.service.adminService.areaAdminFunction.areaAdminAddOrChangeOrDeleteSpotAdmin;

import java.util.List;

import com.data.model.AreaAdminAddOrChangeOrDeleteSpotAdminModel;

public interface AreaAdminAddOrChangeOrDeleteSpotAdminService {
	  //根据景区管理员Account得到景区管理员所在景区的景点管理员的Account,Aid,以及景点管理员所管理景点的Spot,Sid
      public List<AreaAdminAddOrChangeOrDeleteSpotAdminModel> getSpotAdminInformations(AreaAdminAddOrChangeOrDeleteSpotAdminModel areaAdminAddOrChangeOrDeleteSpotAdminModel);
}
