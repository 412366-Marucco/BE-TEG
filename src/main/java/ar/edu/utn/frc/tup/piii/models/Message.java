package ar.edu.utn.frc.tup.piii.models;

import lombok.Data;

import java.time.LocalDateTime;
/**
 * Representa un mensaje dentro de la partida, que puede ser generado por un jugador o por el sistema.
 * Incluye la marca de tiempo de creación, el remitente (jugador, o null si es del sistema), y el texto del mensaje.
 * Ejemplos de uso:
 * - Mensajes de chat entre jugadores.
 * - Notificaciones del sistema (por ejemplo, "Inicia el turno de Juan", "El jugador Azul fue derrotado").
 */
@Data
public class Message {
    private final LocalDateTime timestamp;
    private final Player player;
    private final String text;

    /**
     * Crea un nuevo mensaje con el jugador remitente y el texto indicado.
     * Si el mensaje es del sistema, el parámetro player debe ser null.
     *
     * @param player Jugador que envía el mensaje, o null si es del sistema.
     * @param text Texto del mensaje.
     */
    public Message(Player player, String text) {
        this.timestamp = LocalDateTime.now();
        this.player = player;
        this.text = text;
    }

    /**
     * Representación en texto del mensaje, mostrando el timestamp, el nombre del jugador (o "Sistema" si es null), y el texto.
     * @return String descriptivo del mensaje.
     */
    @Override
    public String toString() {
        String playerName = (player != null) ? player.getName() : "Sistema";
        return "[" + timestamp + "] " + playerName + ": " + text;
    }
}
