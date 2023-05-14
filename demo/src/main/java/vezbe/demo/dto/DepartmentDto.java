package vezbe.demo.dto;

import vezbe.demo.model.Department;

public class DepartmentDto {

    private Long id;
    private String nazivDepartmana;
    private String nazivKompanije;

    public DepartmentDto(Long id, String nazivDepartmana, String nazivKompanije) {
        this.id = id;
        this.nazivDepartmana = nazivDepartmana;
        this.nazivKompanije = nazivKompanije;
    }

    public DepartmentDto(Department department) {
        this.id = department.getId();
        this.nazivDepartmana = department.getName();
        this.nazivKompanije = department.getCompany().getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazivDepartmana() {
        return nazivDepartmana;
    }

    public void setNazivDepartmana(String nazivDepartmana) {
        this.nazivDepartmana = nazivDepartmana;
    }

    public String getNazivKompanije() {
        return nazivKompanije;
    }

    public void setNazivKompanije(String nazivKompanije) {
        this.nazivKompanije = nazivKompanije;
    }
}
