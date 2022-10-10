package com.example.uana

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.uana.databinding.FragmentCadastrousuario1Binding
import com.example.uana.fragment.DatePickerFragment
import com.example.uana.fragment.TimerPickerListener
import java.time.LocalDate

class CadastroUsuarioFragment : Fragment(), TimerPickerListener {

    private lateinit var binding : FragmentCadastrousuario1Binding
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

    binding = FragmentCadastrousuario1Binding.inflate(layoutInflater, container, false)

    mainViewModel.dataSelecionada.value = LocalDate.now()
    mainViewModel.dataSelecionada.observe(viewLifecycleOwner){
        selectDate -> binding.editdataNasc.setText(selectDate.toString())
    }

    nomeCompletoFocusListener()
    emailFocusListener()
    passwordFocusListener()
    cpfFocusListener()
    phoneFocusListener()

    binding.buttonNext.setOnClickListener {
        findNavController().navigate(R.id.action_cadastroUsuarioFragment_to_cadastroUsuario2Fragment)
    }

    binding.buttonVoltar.setOnClickListener {
        findNavController().navigate(R.id.action_cadastroUsuarioFragment_to_loginFragment2)
    }

    binding.editdataNasc.setOnClickListener {
        DatePickerFragment(this)
            .show(parentFragmentManager, "DatePicker")
    }


    return binding.root
            }

    private fun nomeCompletoFocusListener(){
        binding.editNome.setOnFocusChangeListener { _, focused ->
            if( !focused ){
                binding.nomeContainer.helperText = validNomeCompleto()
            }
        }
    }

    private fun validNomeCompleto() : String?{
        val nomeText = binding.editNome.text.toString()
        if( nomeText == "" || nomeText.length < 3 || nomeText.length > 30 ){
            return "Digite um nome válido!"
        }
        return null
    }

    private fun emailFocusListener(){
        binding.editEmail.setOnFocusChangeListener { _, focused ->
            if( !focused ){
                binding.emailContainer.helperText = validEmail()
            }
        }
    }

    private fun validEmail() : String?{
        val emailText = binding.editEmail.text.toString()
        if( !Patterns.EMAIL_ADDRESS.matcher(emailText).matches() ){
            return "E-mail inválido!"
        }
        return null
    }

    private fun passwordFocusListener(){
        binding.senhaEmail.setOnFocusChangeListener { _, focused ->
            if( !focused ){
                binding.senhaContainer.helperText = validPassword()
            }
        }
    }

    private fun validPassword() : String? {
        val passwordText = binding.senhaEmail.text.toString()
        if( passwordText.length < 8){
            return "A senha deve conter no minimo 8 caracteres!"
        }
        if( !passwordText.matches(".*[A-Z].*".toRegex()) ){
            return "A senha deve conter pelo menos uma letra maiúscula!"
        }
        if( !passwordText.matches(".*[a-z].*".toRegex()) ){
            return "A senha deve conter pelo menos uma letra minúscula!"
        }
        if( !passwordText.matches(".*[@#\$%^&+=.].*".toRegex()) ){
            return "A senha deve conter pelo menos um caractere especial!"
        }
        return null
    }

    private fun cpfFocusListener(){
        binding.editCPF.setOnFocusChangeListener { _, focused ->
            if( !focused ){
                binding.cpfContainer.helperText = validCpf()
            }
        }
    }

    private fun validCpf() : String? {
        val cpf = binding.editCPF.text.toString()
        if( !cpf.matches(".*[0-9].*".toRegex()) ){
            return "O numero do CPF só deve conter números!"
        }
        if( cpf.length < 8 || cpf.length > 11){
            "CPF inválido!"
        }
        return null
    }

    private fun phoneFocusListener(){
        binding.editTel.setOnFocusChangeListener{ _, focused ->
            if( !focused ){
                binding.TelContainer.helperText = validPhone()
            }
        }
    }

    private fun validPhone() : String? {
        val editPhone = binding.editTel.text.toString()
        if( !editPhone.matches(".*[0-9].*".toRegex()) ){
            return "O telefone só deve conter números!"
        }
        if( editPhone.length != 11 ){
            return "Deve conter 11 numeros!"
        }
    return null
    }

    override fun onDateSelected(date: LocalDate) {
        mainViewModel.dataSelecionada.value = date
    }
}
