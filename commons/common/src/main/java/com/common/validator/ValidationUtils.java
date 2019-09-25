package com.common.validator;

import com.common.exception.RRException;
import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**   
 * 所属公司：稻普控股集团
 * 项目名称：video-parent-base   
 * 类名称：ValidationUtils   
 * 类描述：   
 * 创建人：zhangpp
 * 创建时间：2018年3月27日 下午1:50:32   
 * 修改人：zhangpp
 * 修改时间：2018年3月27日 下午1:50:32   
 * 修改备注：   
 * @version V1.0     
 */
public class ValidationUtils {

	/**
	 *  @Null   被注释的元素必须为 null    
		@NotNull    被注释的元素必须不为 null    
		@AssertTrue     被注释的元素必须为 true    
		@AssertFalse    被注释的元素必须为 false    
		@Min(value)     被注释的元素必须是一个数字，其值必须大于等于指定的最小值    
		@Max(value)     被注释的元素必须是一个数字，其值必须小于等于指定的最大值    
		@DecimalMin(value)  被注释的元素必须是一个数字，其值必须大于等于指定的最小值    
		@DecimalMax(value)  被注释的元素必须是一个数字，其值必须小于等于指定的最大值    
		@Size(max=, min=)   被注释的元素的大小必须在指定的范围内    
		@Digits (integer, fraction)     被注释的元素必须是一个数字，其值必须在可接受的范围内    
		@Past   被注释的元素必须是一个过去的日期    
		@Future     被注释的元素必须是一个将来的日期    
		@Pattern(regex=,flag=)  被注释的元素必须符合指定的正则表达式
		Hibernate Validator提供的校验注解：  
		@NotBlank(message =)   验证字符串非null，且长度必须大于0    
		@Email  被注释的元素必须是电子邮箱地址    
		@Length(min=,max=)  被注释的字符串的大小必须在指定的范围内    
		@NotEmpty   被注释的字符串的必须非空    
		@Range(min=,max=,message=)  被注释的元素必须在合适的范围内
	 * 
	 */

	/**
     * 使用hibernate的注解来进行验证
     */
	private static Validator validator = Validation.byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory().getValidator();
	
	/**
     * 功能描述: <br>
     * 〈注解验证参数〉
     * @param obj
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static <T> void validate(T obj) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj);
        // 抛出检验异常
		for (ConstraintViolation constraint : constraintViolations) {
			throw new RRException(constraint.getMessage());
		}
    }

	/**
	 * 校验对象
	 * @param object        待校验对象
	 * @param groups        待校验的组
	 */
	public static void validateEntity(Object object, Class<?>... groups) {
		Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
		for (ConstraintViolation constraint : constraintViolations) {
			throw new RRException(constraint.getMessage());
		}
	}
}
