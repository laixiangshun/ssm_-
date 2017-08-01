package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.entity.Role;

public interface IRoleDao {
	
	public String roleNameById(int id);
	
	public String authIdsById(int id);
	
	public List<Role> roleList(Role role);
	
	public int roleCount(Role role);
	
	public int roleDelete(String delIds);
	
	public int roleAdd(Role role);
	
	public int roleUpdate(Role role);
	
	public int roleAuthIdsUpdate(Role role);
}