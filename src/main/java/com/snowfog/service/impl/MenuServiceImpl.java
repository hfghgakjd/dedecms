package com.snowfog.service.impl;

import com.snowfog.Utils.ConvertUtils;
import com.snowfog.dao.MenuDao;
import com.snowfog.entity.TreeNode;
import com.snowfog.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuDao menuDao;


    @Override
    public List<TreeNode> getMenusByParentId(String parentId) {
        List<TreeNode> menus = menuDao.getMenuByParentId(parentId);
        return menus;
    }

    @Override
    public List<TreeNode> getTreeMenu(String pId) {
        List<TreeNode> trees = menuDao.getMenuTrees(pId);

        return trees;

    }

    /**
     * <p>
     * 描述: 查询菜单表
     * </p>
     *
     * @param params <p><strong>1.</strong>page:当前页</p>
     *               <p><strong>2.</strong>rows:每页大小</p>
     * @return
     * @author snowfog shao
     */
    @Override
    public Map<String, Object> getTreePagination(Map<String, Object> params) {
        List<Map<String, Object>> trees = menuDao.getTreePagination(params);
        int count = menuDao.getTreePaginationCount(params);
        transCode(trees);
        Map<String,Object> result = new HashMap<>();
        result.put("rows",trees);
        result.put("total",count);
        return result;
    }

    private void transCode(List<Map<String, Object>> trees) {
        trees.forEach(tree -> {
            if (StringUtils.isEmpty(ConvertUtils.cString(tree.get("url")))) {
                tree.put("url", "无");
            }
            if ("close".equals(ConvertUtils.cString(tree.get("state")))) {
                tree.put("state","关闭");
            }else{
                tree.put("state","展开");
            }
            if ("false".equals(ConvertUtils.cString(tree.get("isLeaf")))){
                tree.put("isLeaf","否");
            }else{
                tree.put("isLeaf","是");
            }
            if ("0".equals(ConvertUtils.cString(tree.get("parentId")))){
                tree.put("parentId","无");
            }
        });
    }

	@Override
	@Transactional(value="txManager")
	public boolean addMenu(Map<String, Object> params) {
		Map<String,Object> paramsMap = new HashMap<>();
		params.forEach((k,v) -> {
			if("state".equals(k)){
				params.put("state", "false".equals(ConvertUtils.cString(v))?"0":"1");
			}
			if("isLeaf".equals(k)) {
				params.put("isLeaf", "false".equals(ConvertUtils.cString(v))?"0":"1");
			}
		});
		paramsMap.put("text",ConvertUtils.cString(params.get("name")));
		paramsMap.put("state", ConvertUtils.cString(params.get("state")));
		paramsMap.put("children",null);
		paramsMap.put("iconCls",ConvertUtils.cString(params.get("iconCls")));
		paramsMap.put("isLeaf", ConvertUtils.cString(params.get("isLeaf")));
		paramsMap.put("url", ConvertUtils.cString(params.get("url")));
		int i = menuDao.insert(paramsMap);
		return i==1;
	}
}
