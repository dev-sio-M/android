package fr.gsb;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import fr.gsb.R;
import fr.gsb.rv.entites.Visiteur;
import fr.gsb.rv.modeles.ModeleGsb;

public class MainActivity extends AppCompatActivity {

    EditText matricule;
    EditText mdp;
    Button btn_valider;
    Button btn_annuler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        matricule = findViewById(R.id.matricule);
        mdp = findViewById(R.id.mdp);
        btn_valider = findViewById(R.id.Valider);
        btn_annuler = findViewById(R.id.Annuler);

        btn_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String matriculeStr = matricule.getText().toString();
                String mdpStr = mdp.getText().toString();

                if (!matriculeStr.isEmpty() && !mdpStr.isEmpty()) {
                    // Utiliser le modèle pour vérifier la connexion
                    Visiteur visiteur = ModeleGsb.getInstance().seConnecter(matriculeStr, mdpStr);

                    if (visiteur != null) {
                        // L'utilisateur est connecté avec succès
                        // Ajoutez le code pour gérer le cas de connexion réussie
                        Toast.makeText(MainActivity.this, "Connecter en tant que " + visiteur.getPrenom() + " " + visiteur.getNom(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Echec à la connexion. Recommencez...", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btn_annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Ajoutez le code pour gérer le bouton Annuler
                // Par exemple, effacer les champs de saisie
                matricule.setText("");
                mdp.setText("");
            }
        });
    }
}
