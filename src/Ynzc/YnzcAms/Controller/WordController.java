package Ynzc.YnzcAms.Controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Model.WordSet;

public class WordController extends BaseController{

	private final static Logger log = Logger.getLogger(WordController.class);
    
	public void findWordSet(HttpServletRequest request,HttpServletResponse response)throws Exception {
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("Action findWordSet");
		String wordtype=request.getParameter("wordType");
		String topMargin=request.getParameter("topMargin");
		String bottomMargin=request.getParameter("bottomMargin");
		String leftMargin=request.getParameter("leftMargin");
		String rightMargin=request.getParameter("rightMargin");
		String cnWord=request.getParameter("cnWord");
		int unitid=((User)request.getSession().getAttribute("user")).getUnitid();
		WordSet wordset=serviceManager.getWordSetService().findWordSetByWordTypeandUnitid(wordtype,unitid);
		WordSet wordsetnew=new WordSet();
		if(wordset!=null){	
			wordsetnew=wordset;
		}else{
			wordsetnew.setUnitid(unitid);
			wordsetnew.setWordtype(wordtype);
			wordsetnew.setTopMargin(topMargin);
			wordsetnew.setBottomMargin(bottomMargin);
			wordsetnew.setLeftMargin(leftMargin);
			wordsetnew.setRightMargin(rightMargin);
			wordsetnew.setCnWord(cnWord);
			serviceManager.getWordSetService().addWordSet(wordsetnew);
			wordsetnew=serviceManager.getWordSetService().findWordSetByWordTypeandUnitid(wordtype, unitid);
		}
		JSONObject jsonBack = new JSONObject();
		jsonBack.put("data", JSONObject.fromObject(wordsetnew));
		jsonBack.put("totalCount", wordtype);
		System.out.println(jsonBack);
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonBack);
	}
//	public void getAllListByPage(HttpServletRequest request,
//			HttpServletResponse response) throws Exception{
//		String start = null;
//		String limit = null;
//		log.info("Someone come from ip address <" + request.getRemoteAddr()
//				+ ">");
//		log.info("Action getAllListByPage");
//		if (request.getParameter("start").trim() != null) {
//			start = (String) request.getParameter("start").trim();
//			log.info(start);
//		} else {
//			log.info("start is null");
//		}
//		if (request.getParameter("limit").trim() != null) {
//			limit = (String) request.getParameter("limit").trim();
//			log.info(limit);
//		} else {
//			log.info("limit is null");
//		}
//		Page page = new Page(Integer.parseInt(start), Integer.parseInt(limit));
//		String fields = request.getParameter("fields");//获取查询字段
//		String query = request.getParameter("query");//获取查询输入框中输入的查询值
//		String condition = "";//设置查询条件为空
//		if (fields != null && query != null) {
//			condition = new FieldsAndQueryToCondition()
//					.FieldsAndQueryToCondition(fields, query);
//		}
//		List<WordSet> res = serviceManager.getWordSetService().getAllWordSet(page, condition);
//		JSONArray jsonItems = new JSONArray();
//		for (WordSet u : res) {
//			jsonItems.add(JSONObject.fromObject(u));
//		}
//		JSONObject jsonBack = new JSONObject();
//		jsonBack.put("data", jsonItems);
//		jsonBack.put("totalCount", page.getTotalCount());
//		System.out.println(jsonBack);
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("application/json;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.print(jsonBack);
//	}
	//添加
//	public void addWordSet(HttpServletRequest request, HttpServletResponse response)throws Exception {
//		request.setCharacterEncoding("UTF-8");
//		response.setContentType("text/json;charset=utf-8");
//		String wordtype=request.getParameter("wordtype");
//		String WordSettopMargin=request.getParameter("WordSettopMargin");
//		String WordSetbottomMargin=request.getParameter("WordSetbottomMargin");
//		String WordSetleftMargin=request.getParameter("WordSetleftMargin");
//		String WordSetrightMargin=request.getParameter("WordSetrightMargin");
//		WordSet model=new WordSet();
//		model.setUnitid(((User)request.getSession().getAttribute("user")).getUnitid());
//		model.setWordtype(wordtype);
//		model.setTopMargin(WordSettopMargin);
//		model.setBottomMargin(WordSetbottomMargin);
//		model.setLeftMargin(WordSetleftMargin);
//		model.setRightMargin(WordSetrightMargin);
//		if (serviceManager.getWordSetService().addWordSet(model)) {
//			log.info("添加报表样式成功");
//			request.setCharacterEncoding("UTF-8");
//			response.setContentType("text/json;charset=utf-8");
//			response.getWriter().write("{success: true}");
//		} else {
//			response.getWriter().write("{errors:'添加报表样式失败，请重新尝试!'}");
//		}
//	}
	//更新
	public void updateWordSet(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		log.info("Someone come from ip address <" + request.getRemoteAddr()
				+ ">");
		log.info("Action updateWordSet");
		int id=Integer.parseInt(request.getParameter("id"));
		int unitid=Integer.parseInt(request.getParameter("unitid"));
		String wordtype=request.getParameter("wordtype");
		String WordSettopMargin=request.getParameter("WordSettopMargin");
		String WordSetbottomMargin=request.getParameter("WordSetbottomMargin");
		String WordSetleftMargin=request.getParameter("WordSetleftMargin");
		String WordSetrightMargin=request.getParameter("WordSetrightMargin");
		String cnWord=request.getParameter("cnWord");
		WordSet wordset=new WordSet(id,WordSettopMargin,WordSetbottomMargin,WordSetleftMargin,WordSetrightMargin,unitid,wordtype,cnWord);
		log.info("update WordSet id="+id);
		if(!serviceManager.getWordSetService().updateWordSet(wordset)){
			log.info("Err on update WordSet");
			response.getWriter().write("{failure:true,reason:'更新报表样式失败'}");
		}
		response.getWriter().write("{success: true}");
	}
	//删除
//	public void delWordSet(HttpServletRequest request, HttpServletResponse response)throws Exception {
//		request.setCharacterEncoding("UTF-8");
//		response.setContentType("text/json;charset=utf-8");
//		log.info("Someone come from ip address <" + request.getRemoteAddr()+ ">");
//		log.debug("Del WordSet");
//		String delIds = (String) request.getParameter("dellist").trim();
//		JSONArray jsonArray = JSONArray.fromObject(delIds);
//		Iterator iterator = jsonArray.iterator();
//		JSONObject jsonObject = new JSONObject();
//		while (iterator.hasNext()) {
//			jsonObject = JSONObject.fromObject(iterator.next());
//			WordSet model = (WordSet)JSONObject.toBean(jsonObject,WordSet.class);
//			boolean isDelete = serviceManager.getWordSetService().delWordSet(model);
//			if (!isDelete) {
//				log.info("Err on delete Certificate");
//				response.getWriter().write("{failure:true,reason:'删除报表样式失败'}");
//			}
//		}
//		response.getWriter().write("{success: true}");
//	}
}
