package tagHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import models.User;

public class UserTable extends SimpleTagSupport implements DynamicAttributes {

	private ArrayList<User> users;

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.print("<table ");
		for (String key : attr.keySet()) {
			out.print(String.format(ATTR_TEMPLATE, key, attr.get(key)));
		}
		out.print(">");

		out.print("<thead>");
		out.print("<tr>");
		out.print(String.format(TH_TEMPLATE, "Id"));
		out.print(String.format(TH_TEMPLATE, "Name"));		
		out.print(String.format(TH_TEMPLATE, "Tasks"));		
		out.print("</tr>");
		out.print("</thead>");

		for (User user : users) {
			out.print("<tr>");
			out.print(String.format(TD_TEMPLATE, user.getId()));
			out.print(String.format(TD_TEMPLATE, user.getName()));
			out.print(String.format(TD_TEMPLATE, "<button>Show Tasks</button>"));
			out.print("</tr>");
		}

		out.print("</table");
	}

	private Map<String, Object> attr = new HashMap<>();

	@Override
	public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {

		attr.put(localName, value);
	}

	private static String ATTR_TEMPLATE = " %s='%s' ";
	private static String TH_TEMPLATE = "<td>%s</td";
	private static String TD_TEMPLATE = "<td>%s</td";

}
