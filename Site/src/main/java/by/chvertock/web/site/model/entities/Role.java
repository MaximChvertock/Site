package by.chvertock.web.site.model.entities;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "role")
public class Role implements Serializable {
    
    private static final long serialVersionUID = -8818298759858955363L;
    
    // predefined roles
    public static final Role ROLE_ADMIN = new Role(RoleType.ROLE_ADMIN, "Administarator");
    public static final Role ROLE_USER = new Role(RoleType.ROLE_USER, "User");
    public static final Role ROLE_ANON = new Role(RoleType.ROLE_ANON, "Anonymous");
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id", unique = true, nullable = false)
    private int id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private RoleType type;
    
    @Column(name = "name")
    private String name;
    
    public Role(){/*IMPORTANT DEFAULT CONSTRUCTOR*/}

    private Role(RoleType type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }   

    public RoleType getType() {
        return type;
    }

    public void setType(RoleType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

 
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((type == null) ? 0 : type.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	Role other = (Role) obj;
	if (id != other.id) {
	    return false;
	}
	if (name == null) {
	    if (other.name != null) {
		return false;
	    }
	} else if (!name.equals(other.name)) {
	    return false;
	}
	if (type != other.type) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "Role [id=" + id + ", type=" + type + ", name=" + name + "]";
    }

    
    
    
}
