package ultil;

import java.util.Map;

public class MapUltil {
        public static <T> T getObject(Map<String,Object> params,String key,Class<T> tClass) {
        	Object obj = params.getOrDefault(key, null);
        	if(obj !=null) {
        		if(tClass.getTypeName().equals("java.lang.long")) {
        			obj =obj != "" ?Long.valueOf(obj.toString()):null;
        		}
        		else if(tClass.getTypeName().equals("java.lang.Integer")) {
        			obj =obj != "" ?Integer.valueOf(obj.toString()):null;
        		}
        		else if(tClass.getTypeName().equals("java.lang.String")) {
        			obj =obj != "" ?obj.toString():null;
        		}
        		return tClass.cast(obj);
        	}else {
        		return null;
        	}
        	
        }
}
