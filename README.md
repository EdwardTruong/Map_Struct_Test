# Map_Struct_Test
Spring boot with main is mapstruct.

khi sử dụng mapstruck thì nó tự động raneder ra code cho mình ở những hàm mapper. 


		<dependency>
			<groupId>org.mapstruct</groupId>
			<artifactId>mapstruct</artifactId>
			<version>1.4.2.Final</version> <!-- Use the latest version -->
		</dependency>
		<dependency>
			<groupId>org.mapstruct</groupId>
			<artifactId>mapstruct-processor</artifactId>
			<version>1.4.2.Final</version> <!-- Use the same version as mapstruct -->
			<scope>provided</scope>
		</dependency>

Thì chỉ cần mình sử dụng interface tên của object DTO.
Trong interface sẽ có tên method đánh dấu trên các method là các @Mapper(target = "tên_field_DTO", source="ENTITY.tên_field")

Ví dụ /**
 * UserMapper
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "userId", source = "entity.id")
    UserDto toDto(UserEntity entity);

    UserEntity toEntity(UserDto dto);

}


Sau đó sẽ đên bước sử dụng cmd của 

Nhập vào : mvn clean install.
Xóa các install có sẵn sau đó build lại.

mvn install để code tự gen ra ở mục target / genarate source / UserMapper luôn mà không cần code. 

Hãy chú ý đến các filed. Ví dụ : 


@Mapping(target="employeeId", source = "entity.id")
@Mapping(target="employeeName", source = "entity.name")
@Mapping(target="employeeStartDt", source = "entity.startDt", dateFormat = "dd-MM-yyyy HH:mm:ss") <-------------- Cho ngày giờ 
         
EmployeeDTO employeeToEmployeeDTO(Employee entity);

@Mapping(target="id", source="dto.employeeId")
@Mapping(target="name", source="dto.employeeName")
@Mapping(target="startDt", source="dto.employeeStartDt",  dateFormat="dd-MM-yyyy HH:mm:ss") <-------------- Cho ngày giờ 
       
Employee employeeDTOtoEmployee(EmployeeDTO dto);
