package models;

import lombok.*;

@Data
@Builder
public class UserProfile {
	private Integer birthDay;
	private MONTHS birthMonth;
	private Integer birthYear;
	private String name;
	private SEX sex;

	@RequiredArgsConstructor
	@Getter
	public enum SEX {
		M("Мужчина"),
		W("Женщина");

		private final String value;
	}

	@RequiredArgsConstructor
	@Getter
	public enum MONTHS {
		JAN("Январь"),
		FEB("Февраль"),
		MAR("Март"),
		APR("Апрель"),
		MAY("Май"),
		JUN("Июнь"),
		JUL("Июль"),
		AUG("Август"),
		SEP("Сентябрь"),
		OCT("Октябрь"),
		NOV("Ноябрь"),
		DEC("Декабрь");

		private final String value;
	}
}
