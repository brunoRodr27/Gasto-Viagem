package com.example.gasto_viagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os
import android.view.View
import android.widget.Toast
import com.example.gasto_viagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalcular.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_calcular){
            calcular()
        }
    }

    private fun validacao() : Boolean{
        return (binding.editDistancia.text.toString() != ""
                && binding.editPreco.text.toString() != ""
                && binding.editAutonomia.text.toString() != "")
    }

    private fun calcular(){
        if (validacao()) {
            if (binding.editAutonomia.text.toString().toFloat() != 0f) {
                val distancia = binding.editDistancia.text.toString().toFloat()
                val preco = binding.editPreco.text.toString().toFloat()
                val autonomia = binding.editAutonomia.text.toString().toFloat()

                val valorTotal = (distancia * preco) / autonomia
                binding.textValorTotal.text = "R$ ${"%.2f".format(valorTotal)}"
            } else {
                Toast.makeText(this, R.string.valorzero, Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, R.string.validacao, Toast.LENGTH_SHORT).show()
        }
    }
}