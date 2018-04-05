package kr.co.sunnyvale.mvcexam.dto;

public class Blood {
	private String name;
	private String bloodType;
	private String msg;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getMsg() {

		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Blood{" +
				"name='" + name + '\'' +
				", bloodType='" + bloodType + '\'' +
				", msg='" + msg + '\'' +
				'}';
	}
}
