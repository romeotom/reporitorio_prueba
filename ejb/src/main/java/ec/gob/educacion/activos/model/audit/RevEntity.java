package ec.gob.educacion.activos.model.audit;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

@Entity
@Table(name = "revinfo")
@RevisionEntity(AuditListener.class)
@SequenceGenerator(name = "SEQ_REV_INFO_GEN", sequenceName = "SEQ_REQ_INFO", allocationSize = 1)
public class RevEntity implements Serializable {

	private static final long serialVersionUID = 7124298942852104473L;

	@Id
	@GeneratedValue(generator = "SEQ_REV_INFO_GEN", strategy = GenerationType.SEQUENCE)
	@RevisionNumber
	private int id;

	@RevisionTimestamp
	private long timestamp;

	private String usuario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
