package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.WordSetDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.WordSet;
import Ynzc.YnzcAms.Service.WordSetService;

public class WordSetServiceImpl implements WordSetService {
    private WordSetDao wordSetDao;
	public List<WordSet> getAllWordSet(Page page, String conditions) {
		// TODO Auto-generated method stub
		return this.wordSetDao.getAllWordSet(page, conditions);
	}

	public boolean updateWordSet(WordSet wordset) {
		// TODO Auto-generated method stub
		return this.wordSetDao.updateWordSet(wordset);
	}

	public WordSet findWordSetByWordType(String wordType) {
		// TODO Auto-generated method stub
		return this.wordSetDao.findWordSetByWordType(wordType);
	}
	
	public WordSetDao getWordSetDao() {
		return wordSetDao;
	}

	public void setWordSetDao(WordSetDao wordSetDao) {
		this.wordSetDao = wordSetDao;
	}

	public boolean addWordSet(WordSet wordset) {
		return this.wordSetDao.addWordSet(wordset);
	}

	public boolean delWordSet(WordSet wordset) {
		// TODO Auto-generated method stub
		return this.wordSetDao.delWordSet(wordset);
	}

	public WordSet findWordSetByWordTypeandUnitid(String wordType,int unitid) {
		// TODO Auto-generated method stub
		return this.wordSetDao.findWordSetByWordTypeandUnitid(wordType,unitid);
	}
}
