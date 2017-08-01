package cn.bdqn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.dao.IRoleDao;
import cn.bdqn.entity.Role;

@Service
public class RoleServices implements IRoleServices{
	
	@Autowired
	IRoleDao iRoleDao;
	@Override
	public String getRoleNameById(int id) {
		return iRoleDao.roleNameById(id);
	}

	@Override
	public String getAuthIdsById(int id) {
		return iRoleDao.authIdsById(id);
	}

	@Override
	public List<Role> getRoleList(Role role) {
		return iRoleDao.roleList(role);
	}

	@Override
	public int getRoleCount(Role role) {
		return iRoleDao.roleCount(role);
	}

	@Override
	public int getRoleDelete(String delIds) {
		return iRoleDao.roleDelete(delIds);
	}

	@Override
	public int getRoleAdd(Role role) {
		return iRoleDao.roleAdd(role);
	}

	@Override
	public int getRoleUpdate(Role role) {
		return iRoleDao.roleUpdate(role);
	}

	@Override
	public int getRoleAuthIdsUpdate(Role role) {
		return iRoleDao.roleAuthIdsUpdate(role);
	}
}