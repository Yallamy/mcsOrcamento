package br.com.mesttra.mcs.orcamento;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang3.RandomUtils;


/**
 * Classe de teste auxilar.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 1 de out. de 2020
 */
public class EntityGenericUtil {

	public static Integer getInteger() {
		return RandomUtils.nextInt(0, 999999);
	}

	public static Long getLong() {
		return RandomUtils.nextLong(0, 999999);
	}

	public static Long getLong(int length) {

		long value = RandomUtils.nextLong(1111111111111111111L, 9219999999999999999L);
		return Long.parseLong(String.valueOf(value).substring(0, length));
	}

	public static String getString() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	public static String getString(int tamanhoMax) {
		
		String dado = UUID.randomUUID().toString().replace("-", "");
		
		if(dado.length() > tamanhoMax) {
			return dado.substring(0, tamanhoMax);
		}
		
		return dado;
	}

	public static BigInteger getBigInteger() {
		return new BigInteger(getInteger().toString());
	}

	public static Date getDate() {
		return Calendar.getInstance().getTime();
	}

	public static LocalDateTime getDateTime() {
		return LocalDateTime.now();
	}

	public static BigDecimal getBigDecimal() {
		return new BigDecimal(String.valueOf(RandomUtils.nextDouble(0, 999999)));
	}

	public static Double getDouble() {
		return Double.valueOf(RandomUtils.nextDouble(0, 999999));
	}

	public static LocalDate getLocalDate() {

		return LocalDate.now();
	}

	public static LocalDateTime getLocalDateTime() {
		return LocalDateTime.now();
	}

	public static Boolean getBoolean() {
		return new Random().nextBoolean();
	}
	
	public static String getEmail() {
		return UUID.randomUUID().toString().replace("-", "").substring(0, 5) 
				+ "@" + UUID.randomUUID().toString().replace("-", "").substring(0, 5) 
				+ ".com";
	}
	
	public static String getTelefone() {
		
		Long ddd = RandomUtils.nextLong(10, 99);
		Long parte1 = RandomUtils.nextLong(1000, 99999);
		Long parte2 = RandomUtils.nextLong(1000, 9999);
		
		return ddd.toString() + parte1.toString() + parte2.toString();
	}
	
	public static String getCPF() {
		Integer cpf_1 = RandomUtils.nextInt(100000000, 999999999);
		Integer cpf_2 = RandomUtils.nextInt(10, 99);
		String cpf = cpf_1.toString() + cpf_2.toString(); 
		
		return cpf;
	}
	
	public static String getCNPJ() {
		Integer cnpj_1 = RandomUtils.nextInt(100000000, 999999999);
		Integer cnpj_2 = RandomUtils.nextInt(10000, 99999);
		String cnpj = cnpj_1.toString() + cnpj_2.toString(); 
		
		return cnpj;
	}

	public static Object getByType(Class<?> type) {

		if (type == Integer.class || type == int.class) {

			return getInteger();

		} else if (type == BigDecimal.class) {

			return getBigDecimal();

		} else if (type == BigInteger.class) {

			return getBigInteger();

		} else if (type == Date.class) {

			return getDate();

		} else if (type == LocalDateTime.class) {

			return getDateTime();

		} else if (type == LocalDate.class) {

			return getDateTime().toLocalDate();

		} else if (type == LocalTime.class) {

			return getDateTime().toLocalTime();

		} else if (type == Long.class) {

			return getLong();

		} else if (type == String.class) {

			return getString();

		}

		return null;
	}

}
