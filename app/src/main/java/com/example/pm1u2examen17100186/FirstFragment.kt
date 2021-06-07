package com.example.pm1u2examen17100186

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.os.Process
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    lateinit var recycler: RecyclerView
    lateinit var adaptador: TransferenciaAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        setHasOptionsMenu(true)

        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler = view.findViewById(R.id.recyclerView)
        recycler.layoutManager = LinearLayoutManager(requireActivity())

        //Medidas Adapter pide una funcion como parametro
        adaptador = TransferenciaAdapter{
            m ->Mostrar(m)
        }

        recycler.adapter = adaptador
    }

    private fun Mostrar(m: transferencia) {
        Snackbar.make(
                recycler,
                "Num. de tarjeta: ${m.numTarjeta}, cantidad: ${m.cantidad}",
                Snackbar.LENGTH_LONG
        ).show()
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.mnu_add -> {
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
                true
            }
            R.id.mnu_salir ->{
                AlertDialog.Builder(requireContext())
                        .setTitle("¿Realmente desea cerrar la aplicación?")
                        .setCancelable(false)
                        .setNegativeButton(android.R.string.cancel, null)
                        .setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which ->

                            // un listener que al pulsar, cierre la aplicacion
                            Process.killProcess(Process.myPid()) //Su funcion es algo similar a lo que se llama cuando se presiona el botón "Forzar Detención" o "Administrar aplicaciones", lo cuál mata la aplicación
                            //finish(); Si solo quiere mandar la aplicación a segundo plano
                        }).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}