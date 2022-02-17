//
//  ViewController.swift
//  InQ_PM
//
//  Created by RooZin on 2022/01/18.
//

import UIKit
import Alamofire

class LogInVC: UIViewController {
    
    var loginManager = LogInManager()
    
    @IBOutlet weak var idField: UITextField!
    @IBOutlet weak var pwField: UITextField!
    
    @IBOutlet weak var logInButton: UIButton!
    @IBOutlet weak var registerButton: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        loginManager.delegate = self
        idField.text = "ID"
        pwField.text = "PW"
    }
    
    
    @IBAction func pressLogIn(_ sender: UIButton) {
        loginManager.logIn(idField.text!, pwField.text!)
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?){ // 키보드 내리기
        self.view.endEditing(true)
    }
    
}

//MARK: - LogInManagerDelegate

extension LogInVC : LogInManagerDelegate {
    
    func loginCheck(_ data: Check) {
        if data.success! == true {
            guard let viewController = self.storyboard?.instantiateViewController(withIdentifier: "Home") else { return }
            viewController.modalPresentationStyle = .fullScreen
            self.present(viewController, animated: true, completion: nil)
        }
        else {
            let alert = UIAlertController(title: "로그인 실패", message: "아이디나 비밀번호가 틀렸습니다.", preferredStyle: UIAlertController.Style.alert)
            let okAction = UIAlertAction(title: "OK", style: .default) { (action) in }
            alert.addAction(okAction)
            present(alert, animated: false, completion: nil)
        }
    }
}
