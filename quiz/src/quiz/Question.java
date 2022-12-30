package quiz;

 final class Question {
	
	public Question(Long quesid, String ques) {
		this.quesid = quesid;
		this.ques = ques;
	}
	private final Long quesid;
	@Override
	public int hashCode() {
		  return this.quesid.intValue() * this.ques.hashCode();
		
		
	}
	@Override
	public String toString() {
		return "Question [quesid=" + quesid + ", ques=" + ques + "]";
	}
	@Override
	public boolean equals(Object obj) {
		 if (obj == this)
		        return true;
		   Question q=(Question) obj;
		    return this.quesid == q.getQuesid() && this.ques == q.getQues();
		
	}
	private final String ques;
	
	public Long getQuesid() {
		return quesid;
	}
	
	public String getQues() {
		return ques;
	}
	

}
