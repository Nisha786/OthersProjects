package in.com.prestige.util;


import org.springframework.orm.hibernate3.HibernateTemplate;

public class HibernateTemplateUtil {
	private HibernateTemplate template;

	/*public void setTemplate(SessionFactory factory) {
		if (template == null) {
			template = new HibernateTemplate(factory);
		}
	}
*/
	public HibernateTemplate getHibernatTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
}
