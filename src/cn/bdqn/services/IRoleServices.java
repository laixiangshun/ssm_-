package cn.bdqn.services;

import java.util.List;

import cn.bdqn.entity.Role;

public interface IRoleServices {
	
	public String getRoleNameById(int id);
	
	public String getAuthIdsById(int id);
	
	public List<Role> getRoleList(Role role);
	
	public int getRoleCount(Role role);
	
	public int getRoleDelete(String delIds);
	
	public int getRoleAdd(Role role);
	
	public int getRoleUpdate(Role role);
	
	public int getRoleAuthIdsUpdate(Role role);

}
