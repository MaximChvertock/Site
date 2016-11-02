package by.chvertock.web.site.web.utils;

public final class ControllerUtils {

    private ControllerUtils() {
	/*NOP*/
    }
    
    public static String redirect(String url){
	return "redirect:"+url;
	
    }

    public static String forward(String url){
	return "forward:"+url;
	
    }

}
