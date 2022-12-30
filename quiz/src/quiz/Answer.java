package quiz;

public class Answer {
	String choice;
	Long ansid;
	String answer;
	Long quesid;
	Boolean isright;
	public Answer(Long ansid, String answer, Long quesid, Boolean isright,String choice) {
		super();
		this.ansid = ansid;
		this.answer = answer;
		this.quesid = quesid;
		this.isright = isright;
		this.choice=choice;
	}
	public Long getAnsid() {
		return ansid;
	}
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	public void setAnsid(Long ansid) {
		this.ansid = ansid;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Long getQuesid() {
		return quesid;
	}
	public void setQuesid(Long quesid) {
		this.quesid = quesid;
	}
	public Boolean getIsright() {
		return isright;
	}
	public void setIsright(Boolean isright) {
		this.isright = isright;
	}
	@Override
	public String toString() {
		return "Answer [choice=" + choice + ", ansid=" + ansid + ", answer=" + answer + ", quesid=" + quesid
				+ ", isright=" + isright + "]";
	}

}
