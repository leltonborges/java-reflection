package br.com.alura.alurator.conversor;

import br.com.alura.alurator.anotacao.NomeTagXML;

import java.lang.reflect.Field;
import java.util.Collection;

public class ConvertXML {
    public static String convert(Object obj) {
        try {
            Class<?> objClass = obj.getClass();

            StringBuilder sb = new StringBuilder();
            if (obj instanceof Collection) {
                Collection<?> colecao = (Collection) obj;
                sb.append("<lista>");
                for (Object o : colecao) {
                    String xml = convert(o);
                    sb.append(xml);
                }
                sb.append("</lista>");
            } else {
                NomeTagXML nomeTagXML = objClass.getDeclaredAnnotation(NomeTagXML.class);

                String nameClasse =
                        nomeTagXML == null ?
                                objClass.getName() :
                                nomeTagXML.name();

                sb.append("<" + nameClasse + ">");
                for (Field f : objClass.getDeclaredFields()) {
                    f.setAccessible(true);
                    NomeTagXML fieldAnnotation = f.getAnnotation(NomeTagXML.class);
                    String nameField =
                            fieldAnnotation == null ?
                                    f.getName() :
                                    fieldAnnotation.name();

                    Object valueField = f.get(obj);
                    sb.append("<" + nameField + ">");
                    sb.append(valueField);
                    sb.append("</" + nameField + ">");
                }
                sb.append("</" + nameClasse + ">");
            }
            return sb.toString();
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao gerar o xml");
        }
    }
}
