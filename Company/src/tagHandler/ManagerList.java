package tagHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import models.User;

public class ManagerList extends SimpleTagSupport implements DynamicAttributes {

	private List<User> users;
	private String teamLeader;
	
	public void setData(List<User> users) {
		this.users = users;
	}
	
	public void setTeamLeader(String teamLeader) {
		this.teamLeader = teamLeader;
	}
	
	private Map<String, Object> attr = new HashMap<>();

	@Override
	public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
		attr.put(localName, value);
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.print(String.format(ATTR_TEMPLATE, "class","list-group"));
		for(String key: attr.keySet()) {
			out.print(String.format(ATTR_TEMPLATE, key,attr.get(key)));
		}
		
		out.print(String.format(ACTIVE_LI_TEMPLATE, teamLeader));
		
		for(User developer : users)
			out.print(String.format(LI_TEMPLATE, developer.getName()));
		
		out.print("</ul>");
	}
	
	private static String ATTR_TEMPLATE = " %s='%s' ";
	private static String LI_TEMPLATE=
			"<li class='list-item-group'>%s</li>";
	private static String ACTIVE_LI_TEMPLATE=
			"<li class='list-item-group active'>%s</li>";

}
