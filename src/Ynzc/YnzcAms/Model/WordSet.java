package Ynzc.YnzcAms.Model;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ynzc_wordset")
public class WordSet {
	public int id;
	public String topMargin;
	public String bottomMargin;
	public String leftMargin;
	public String rightMargin;
	public int unitid;
	public String wordtype;
    public String cnWord;
	
	public WordSet() {
		super();
	}
	public WordSet(int id, String topMargin, String bottomMargin,
			String leftMargin, String rightMargin, int unitid, String wordtype,String cnWord) {
		super();
		this.id = id;
		this.topMargin = topMargin;
		this.bottomMargin = bottomMargin;
		this.leftMargin = leftMargin;
		this.rightMargin = rightMargin;
		this.unitid = unitid;
		this.wordtype = wordtype;
		this.cnWord = cnWord;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTopMargin() {
		return topMargin;
	}

	public void setTopMargin(String topMargin) {
		this.topMargin = topMargin;
	}

	public String getBottomMargin() {
		return bottomMargin;
	}

	public void setBottomMargin(String bottomMargin) {
		this.bottomMargin = bottomMargin;
	}

	public String getLeftMargin() {
		return leftMargin;
	}

	public void setLeftMargin(String leftMargin) {
		this.leftMargin = leftMargin;
	}

	public String getRightMargin() {
		return rightMargin;
	}

	public void setRightMargin(String rightMargin) {
		this.rightMargin = rightMargin;
	}

	public int getUnitid() {
		return unitid;
	}

	public void setUnitid(int unitid) {
		this.unitid = unitid;
	}

	public String getWordtype() {
		return wordtype;
	}

	public void setWordtype(String wordtype) {
		this.wordtype = wordtype;
	}
	public String getCnWord() {
		return cnWord;
	}
	public void setCnWord(String cnWord) {
		this.cnWord = cnWord;
	}
	
}
