package com.gestao_pessoas.tccII.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String entity, Object id) {
		super(getMessage(entity, id));
	}
	
	private static String getMessage(String entity, Object id) {
        switch (entity) {
            case "Colaborador":
                return "Colaborador não encontrado. Id: " + id;
            case "Cargo":
                return "Cargo não encontrado. Id: " + id;
            case "Empresa":
            	return "Empresa não encontrado. Id: " + id;
            case "Plano_Carreira":
            	return "Plano Carreira não encontrado. Id: " + id;
            case "Setor":
            	return "Setor não encontrado. Id: " + id;
            default:
                return "Recurso não encontrado.";
        }
    }

}
