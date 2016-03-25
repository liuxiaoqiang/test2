package Ynzc.YnzcAms.Util;

import net.sf.json.JSONArray;
import Ynzc.Util.StringUtil;
public class TractorInfoSearch {
	public String getTractorInfoSearchCondition(String state,String license, String owner,String realcertificateno,String tempaddress,String condition) {
		if(StringUtil.isNotNullEmptyStr(state)){
			condition+=" and status in ("+state+")";
		}
        if(StringUtil.isNotNullEmptyStr(license)){
        	condition+=" and instr(license,'"+license.trim()+"')";
        }
        if(StringUtil.isNotNullEmptyStr(owner)){
        	condition+=" and instr(owner,'"+owner.trim()+"')"; 
        }
        if(StringUtil.isNotNullEmptyStr(realcertificateno)){
        	condition+=" and instr(realcertificateno,'"+realcertificateno.trim()+"')";
        }
        if(StringUtil.isNotNullEmptyStr(tempaddress)){
        	condition+=" and instr(tempaddress,'"+tempaddress.trim()+"')"; 
        }
        return condition;
	}
	public static String GetBusinessOverCondtion(){
		return " status<>5 ";
	}
	//获取拖拉机各种业务的查询条件
	public static String getBusinessCondition(String state,String codenum, String owner,String machinetype,String dirno,String checkexpriydate,String regcerno,String cardid,String engineno,String buinesstype,String type) {
		String condition = " 1=1 ";//设置查询条件为空
		if(type!=null){
			if(StringUtil.isNotNullEmptyStr(state)){
				if(type.equals("carchange")){
					condition+=" and approvalstate in ("+state+")";
				}
				else if(type.equals("carcheck")){
					condition+=" and checkresult in ("+state+")";
				}
				else if(type.equals("cartransfer")){
					condition+=" and ynzc_cartransfer.checkresult in ("+state+")";
				}
				else if(type.equals("changerecord") || type.equals("logout") || type.equals("mortgage")){
					condition+=" and checkstate in ("+state+")";
				}
				else if(type.equals("replace")){
					condition+=" and examineStatus in ("+state+")";
				}
		    	
			}
			if(buinesstype!=null && !buinesstype.equals("") && !buinesstype.equals("--请选择--")){
				if(type.equals("carchange")){
					condition+=" and changeType='"+buinesstype+"'";
				}
				else if(type.equals("carcheck")){
					condition+=" and checktype="+buinesstype;
				}
				else if(type.equals("cartransfer")){
					condition+=" and transfertype='"+buinesstype+"'";
				}
				else if(type.equals("logout")){
					condition+=" and logtouttype='"+buinesstype+"'";
				}
				else if(type.equals("mortgage")){
					condition+=" and mortgagetype='"+buinesstype+"'";
				}
				else if(type.equals("replace")){
					condition+=" and sortsofinsurance='"+buinesstype+"'";
				}

			}
		}
		if(StringUtil.isNotNullEmptyStr(codenum)){
			condition+=" and instr(license,'"+codenum+"')";
		}
		if(StringUtil.isNotNullEmptyStr(owner)){
			condition+=" and instr(owner,'"+owner+"')"; 
		}
		if(StringUtil.isNotNullEmptyStr(machinetype)){
			condition+=" and instr(tractorinfomachinetype,'"+machinetype+"')";
		}
		if(StringUtil.isNotNullEmptyStr(dirno)){
			condition+=" and instr(tractorinfodirNo,'"+dirno+"')";
		}
		if(StringUtil.isNotNullEmptyStr(checkexpriydate)){
			condition+=" and instr(tractorinfocheckexpirydate,'"+checkexpriydate+"')";
		}
		if(StringUtil.isNotNullEmptyStr(regcerno)){
			condition+=" and instr(regcerno,'"+regcerno+"')";
		}
		if(StringUtil.isNotNullEmptyStr(cardid)){
			condition+=" and instr(realcertificateno,'"+cardid+"')";
		}
		if(StringUtil.isNotNullEmptyStr(engineno)){
			condition+=" and instr(engineno,'"+engineno+"')";
		}

        return condition;
	}
}
