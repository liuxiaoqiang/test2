package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.WordSet;

public interface WordSetService {
	public List<WordSet> getAllWordSet(Page page,String conditions);
	public boolean updateWordSet(WordSet wordset);
	public WordSet findWordSetByWordType(String wordType);
	public WordSet findWordSetByWordTypeandUnitid(String wordType,int unitid);
	public boolean addWordSet(WordSet wordset);
	public boolean delWordSet(WordSet wordset);
}
