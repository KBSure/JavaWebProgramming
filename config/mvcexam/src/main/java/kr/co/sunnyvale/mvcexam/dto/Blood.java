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
		String msg = null;
		if("A".equals(bloodType)){
			msg = "소심합니다.";
		}else if("B".equals(bloodType)){
			msg = "할말을 다합니다.";
		}else if("O".equals(bloodType)) {
			msg = "둥글둥글합니다";
		}else if("AB".equals(bloodType)){
			msg = "알수 없습니다";
		}
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
