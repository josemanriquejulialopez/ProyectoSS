package PracSS;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SeguridadSocial {
    private List<Persona> personasList;

    private Map<String, Persona> personaMapDNI=new HashMap<>();
    private Map<String, Persona> personaMapNumSS=new HashMap<>();


    public SeguridadSocial() {
        personasList = new ArrayList<>();
    }

    // Debes comprobar que no se introduzcan dos personas con el mismo DNI/Número Seguridad Social

    public void altaPersona(Persona persona){
        if(!personaMapDNI.containsKey(persona.getDNI()) &&
                !personaMapNumSS.containsKey(persona.getNumSeguridadSocial())){
            personaMapDNI.put(persona.getDNI(), persona);
            personaMapNumSS.put(persona.getNumSeguridadSocial(), persona);
        }
    }
    public void bajaPersona(String dni){
        if(personaMapDNI.containsKey(dni)) {
            personaMapNumSS.remove(personaMapDNI.get(dni).getNumSeguridadSocial());
            personaMapDNI.remove(dni);
        }
    }
    public Persona obtenerPersonaPorDNI(String dni){
        return personaMapDNI.get(dni);
    }
    public Persona obtenerPersonaPorNumSS(String numSS){
        return personaMapNumSS.get(numSS);
    }
    public Persona obtenerPersonaSalarioMaximo(){
        return personaMapDNI.values().stream().max(Comparator.comparing(Persona::getSalario)).get();
    }
    public Persona obtenerPersonaSalarioMinimo(){
        return personaMapDNI.values().stream().min(Comparator.comparing(Persona::getSalario)).get();
    }
    public List<Persona> obtenerPersonasRangoSalarial(double min, double max){
        return personaMapNumSS.values().stream().filter(persona -> persona.getSalario()>=min
        && persona.getSalario()>=max).collect(Collectors.toList());
    }
    public List<Persona> obtenerPersonasMayoresQue(int edad){
        return personaMapDNI.values().stream().filter(persona -> persona.getEdad()>edad)
                .collect(Collectors.toList());
    }
    public List<Persona> obtenerTodas(){
        return new ArrayList<>(personaMapDNI.values());
    }








    /*---------------------------------------------------*/
/*

   public void altaPersona(Persona persona) {
        boolean esta=false;
        for(int i=0;i<personasList.size();i++){
            if(personasList.get(i).getDNI().equals(persona.getDNI())  ||
                    personasList.get(i).getNumSeguridadSocial().equals(persona.getNumSeguridadSocial())) {
                System.out.println("Persona ya dada de alta");
                esta=true;
            }
        }
        if(esta==false) {
            personasList.add(persona);
        }
    }

    public void bajaPersona(String dni) {
        personasList.removeIf(persona -> persona.getDNI().equals(dni));
    }

    public Persona obtenerPersonaPorDNI(String dni) {
        int y=0;
        for(int i=0;i<personasList.size();i++){
            if(personasList.get(i).getDNI().equals(dni)){
                y=i;
                break;
            }
        }
        return personasList.get(y);
    }

    public Persona obtenerPersonaPorNumSS(String numSS) {
        int y=0;
        for(int i=0;i<personasList.size();i++){
            if(personasList.get(i).getNumSeguridadSocial().equals(numSS)){
                y=i;
            }
        }
        return personasList.get(y);
    }

    public List<Persona> obtenerPersonasRangoSalarial(double min, double max){
        List<Persona> RangoS = new ArrayList();

        for(int i=0;i<personasList.size();i++){
            if(personasList.get(i).getSalario()>=min && personasList.get(i).getSalario()<=max){
                RangoS.add(personasList.get(i));
            }
        }
        return RangoS;
    }

    public List<Persona> obtenerPersonasMayoresQue(int edad){
        List<Persona> PersonasM = new ArrayList();

        for(int i=0;i<personasList.size();i++){
            if(personasList.get(i).getSalario()>edad){
                PersonasM.add(personasList.get(i));
            }
        }
        return PersonasM;
    }

    public List<Persona> obtenerTodas(){
        return personasList;
    }


*/

    @Override
    public String toString() {
        return "SeguridadSocial{" +
                "personasList=" + personasList +
                '}';
    }
}


