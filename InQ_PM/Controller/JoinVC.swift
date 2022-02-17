//
//  JoinVC.swift
//  InQ_PM
//
//  Created by RooZin on 2022/02/13.
//

import UIKit
import Alamofire

class JoinVC: UIViewController {
    
    var joinManager = JoinManager()
    
    @IBOutlet weak var id: UITextField!
    @IBOutlet weak var pw: UITextField!
    @IBOutlet weak var userName: UITextField!
    @IBOutlet weak var position: UITextField!
    @IBOutlet weak var skill: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        joinManager.delegate = self
        // Do any additional setup after loading the view.
    }
    
    @IBAction func pressJoin(_ sender: UIButton) {
        
        joinManager.join(id.text!, pw.text!, userName.text!, position.text!, skill.text!)
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?){ // 키보드 내리기
        self.view.endEditing(true)
    }
    
}

//MARK: - JoinManagerDelegate

extension JoinVC : JoinManagerDelegate {
    func joinCheck(_ data: Check) {
        
        if data.success! == true {
            let alert = UIAlertController(title: "🎉🎉🎉", message: "회원가입이 완료되었습니다.", preferredStyle: UIAlertController.Style.alert)
            let okAction = UIAlertAction(title: "OK", style: .default) { (action) in
                guard let viewController = self.storyboard?.instantiateViewController(withIdentifier: "LogIn") else { return }
                viewController.modalPresentationStyle = .fullScreen
                self.present(viewController, animated: true, completion: nil) }
            alert.addAction(okAction)
            present(alert, animated: false, completion: nil)
        }
        else {
            let alert = UIAlertController(title: "☹️☹️☹️", message: "필수정보가 누락되었습니다.", preferredStyle: UIAlertController.Style.alert)
            let okAction = UIAlertAction(title: "OK", style: .default) { (action) in }
            alert.addAction(okAction)
            present(alert, animated: false, completion: nil)
        }
        
    }
    
    
}
